var baseURI = "/sga/rest";
var getExperimentsAPI = baseURI + "/experiment";
var launchExperimentAPI = getExperimentsAPI + "/launch"
var getExprimentByIdAPI = baseURI + getExperimentsAPI + "/{0}";
var getTasksForExperimentAPI = getExperimentsAPI + "/{0}/tasks";
var app, experimentId, refreshId;
var experimentList = [], taskList = [];

String.prototype.format = function() {
	var args = arguments;

	return this.replace(/\{(\d+)\}/g, function() {
		return args[arguments[1]];
	});
};

function displayMessageOnSuccess(htmlString) {
	$("#myModal .modal-body").html(htmlString);
	$('#myModal').modal('show');
}

function displayOnError(htmlString) {
	$("#errorModal .modal-body").html(htmlString);
	$('#errorModal').modal('show');
}

function jobSubmitSuccess(response) {
	experimentId = JSON.parse(response).experimentId;
	var htmlString = "<p>Job Submitted with ID: " + experimentId + "</p>";
	displayMessageOnSuccess(htmlString); // display success msg
	getExperimentList(); // refresh exp list
	getTasksForExperiment(experimentId); // show tasks for exp

	$("#overlay").css("visibility", "hidden"); // Hide Loading overlay
	$("button[type='reset']").click(); // Clear the array and form
}

function apiErrorResponse(response) {
	response = response.responseJSON;

	var htmlString = "<p>" + "<b>Error Message: Something went wrong!</b>"
			+ "</p>";

	// render error message on page
	displayOnError(htmlString);

	// Hide Loading overlay
	$("#overlay").css("visibility", "hidden");
}

function getExperimentList() {
	$.ajax({
		type : "GET",
		url : getExperimentsAPI,
		headers : {
			'Accept' : "application/json"
		},
		success : function(response) {
			experimentList = response;
			renderExperimentTable();
		},
		error : apiErrorResponse,
	});
}

function renderExperimentTable() {
	var htmlString = "<table id='experimentListTable' class='table table-hover'>"
			+ "<thead>"
			+ "<tr class='active'>"
			+ "<th data-field='srNo' data-sortable='true'> SrNo </th>"
			+ "<th data-field='expName' data-sortable='true'> Exp-Name </th>"
			+ "<th data-field='expType' data-sortable='true'> Exp-Type </th>"
			+ "<th data-field='status' data-sortable='true'> Status </th>"
			+ "<th data-field='startTime' data-sortable='true'> Start </th>"
			+ "<th data-field='endTime' data-sortable='true'> End </th>"
			+ "</tr>" + "</thead>" + "<tbody>";

	var srNo = 1;

	// check if experiment list is empty
	if (!experimentList) {
		var noResultsHTML = "<div class='panel panel-default'>"
				+ "<div class='panel-body'>"
				+ "No experiments found in the database to show! " + "</div>"
				+ "</div";
		// Render html
		$("#experimentList").html(noResultsHTML);
		return;
	} else if (!$.isArray(experimentList)) {
		// add the single dict to array
		experimentList = [ experimentList ];
	}

	$.each(experimentList, function(i, item) {
		var startTime = getformattedDate(item.experimentStartTime);
		var endTime = getformattedDate(item.experimentEndTime);

		htmlString += "<tr>" + "<td>" + (srNo++) + "</td>" + "<td>"
				+ item.experimentId + "</td>" + "<td>" + item.experimentType
				+ "</td>" + "<td>" + item.experimentStatus + "</td>" + "<td>"
				+ startTime + "</td>" + "<td>" + endTime + "</td>" + "</tr>";
	});

	htmlString += "</tbody> </table>";

	// Render html
	$("#experimentListDiv").html(htmlString);
	var expTable = $('#experimentListTable').dataTable({
		"aaSorting" : [ [ 4, "desc" ] ]
	});

	// get item selected from experimentList
	$('#experimentListTable tbody').on(
			'click',
			'tr',
			function() {
				var tableData = $(this).children("td").map(function() {
					return $(this).text();
				}).get();

				console.log('Exp: ' + tableData[1] + ', Type: ' + tableData[2]
						+ ', Status: ' + tableData[3]);
				experimentId = tableData[1];
				getTasksForExperiment(experimentId);
			});
}

function submitJob(application) {
	// Show loading overlay
	$("#overlay").css("visibility", "visible");

	$.ajax({
		type : "POST",
		url : launchExperimentAPI,
		headers : {
			'Content-type' : "text/plain",
			'Accept' : "application/json"
		},
		data : application,
		success : jobSubmitSuccess,
		error : apiErrorResponse,
		dataType : "text"
	});
}

function getTasksForExperiment(experimentId) {
	$.ajax({
		type : "GET",
		url : getTasksForExperimentAPI.format(experimentId),
		headers : {
			'Accept' : "application/json"
		},
		success : function(response) {
			taskList = response;
			clearInterval(refreshId); // clear existing timer
			renderTaskListForExperiment(); // refresh task list
		},
		error : apiErrorResponse,
	});
}

function renderTaskListForExperiment() {
	$('#monitoringDiv').show(); // un-hide the div
	$('#expMonitoring').html(
			"<h4><span class='label label-info'>Experiment: " + experimentId
					+ "</span></h4>"); // display exp being monitored

	var htmlString = "<table id='taskListTable' class='table table-hover'>"
			+ "<thead>" + "<tr class='active'>"
			+ "<th data-field='taskName' data-sortable='true'> Task-Name </th>"
			+ "<th data-field='taskStart' data-sortable='true'> Start </th>"
			+ "<th data-field='taskEnd' data-sortable='true'> End </th>"
			+ "</tr>" + "</thead>" + "<tbody>"; // render the table

	var srNo = 1;

	// check if experiment list is empty
	if (!taskList) {
		var noResultsHTML = "<div class='panel panel-default'>"
				+ "<div class='panel-body'>"
				+ "No tasks found in the database to show! " + "</div>"
				+ "</div";
		// Render html
		$("#taskList").html(noResultsHTML);
		return;
	} else if (!$.isArray(taskList)) {
		// add the single dict to array
		taskList = [ taskList ];
	}

	$.each(taskList, function(i, item) {
		var startTime = getformattedDate(item.taskStartTime);
		var endTime = getformattedDate(item.taskEndTime);

		htmlString += "<tr>" + "<td>" + item.taskName + "</td>" + "<td>"
				+ startTime + "</td>" + "<td>" + endTime + "</td>" + "</tr>";
	});

	htmlString += "</tbody> </table>";

	// Render html
	$("#taskListDiv").html(htmlString);
	$('#taskListTable').dataTable();

	// keep refreshing taskList if exp not ended
	var expStatus = taskList[0].experiment.experimentStatus;

	// refresh progress-bar
	progress = (taskList.length / 5 - 0.01) * 100;
	style = 'width: ' + progress.toString() + '%';
	$('.progress-bar').attr('aria-valuenow', progress.toString());
	$('.progress-bar').attr('style', style);
	$('.progress-bar').html(
			'Experiment {0} ('.format(progress == 100 ? 'Complete' : 'Running')
					+ progress.toString() + '%)');

	// remove success/danger colors
	$('.progress-bar').removeClass('progress-bar-success');
	$('.progress-bar').removeClass('progress-bar-danger');
	$('.progress-bar').addClass('active');

	// check if exp ended
	if (expStatus != 'COMPLETE' && expStatus != 'FAILED') {
		refreshId = setInterval(function() {
			// get new taskList
			getTasksForExperiment(taskList[0].experiment.experimentId);
		}, 3000);
	} else {
		// stop existing timer if exp ended
		clearInterval(refreshId);
		$('.progress-bar').removeClass('active');

		// progress-bar 100%
		$('.progress-bar').attr('aria-valuenow', '100');
		$('.progress-bar').attr('style', 'width: 100%');

		// reformat progress-bar depending on exp-status
		if (expStatus == 'COMPLETE') {
			$('.progress-bar').html('Experiment Complete');
			$('.progress-bar').addClass('progress-bar-success');
		} else if (expStatus == 'FAILED') {
			$('.progress-bar').html('Experiment Failed');
			$('.progress-bar').addClass('progress-bar-danger');
		}
		// refresh exp-list and return
		getExperimentList();
		return;
	}
}

function getformattedDate(date) {
	if (date == null) {
		return 'yet to end';
	} else {
		date = new Date(date);
	}

	var monthNames = [ "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];
	var day = date.getDate();
	var monthIndex = date.getMonth();
	var year = date.getFullYear();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var secs = date.getSeconds();

	return monthNames[monthIndex] + ' ' + day + ', ' + year + ' [' + hours
			+ ':' + minutes + ':' + secs + ']';
}

$(document).ready(function() {
	console.log("document ready!");
	$('#monitoringDiv').hide();

	// get experiment list
	getExperimentList();

	// create handler for submit job
	$("#submitJob").submit(function(event) {
		console.log("Handler for .submit() called.");
		app = $("#application").val();
		submitJob(app);
		event.preventDefault();
	});
});
