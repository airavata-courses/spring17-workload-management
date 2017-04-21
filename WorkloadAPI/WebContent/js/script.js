var baseURI = "/sga/rest";
var getExperimentsAPI = baseURI + "/experiment";
var launchExperimentAPI = getExperimentsAPI + "/launch"
var getExprimentByIdAPI = baseURI + getExperimentsAPI + "/{0}";
var getTasksForExperimentAPI = baseURI + getExperimentsAPI + "/{0}/tasks";
var app, experimentId;

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
	var htmlString = "<p>Job Submitted with ID: " + response.experimentId + "</p>";

	jobID = response.experimentId;
	displayMessageOnSuccess( htmlString );

	// Hide Loading overlay
	$("#overlay").css("visibility", "hidden");

	// Clear the array and form
	$("button[type='reset']").click();
}

function apiErrorResponse(response) {
	response = response.responseJSON;
	
	var htmlString = "<p>" +
					"<b>Error Message: Something went wrong!</b>"+
					"</p>";
	
	// render error message on page
	displayOnError(htmlString);
	
	// Hide Loading overlay
	$("#overlay").css("visibility", "hidden");
}

function submitJob(application) {
	// Show loading overlay
	$("#overlay").css("visibility", "visible");
	
	$.ajax({
		type: "POST",
		url: launchExperimentAPI,
		headers: {
			'Content-type': "text/plain",
			'Accept': "application/json"
		},
		data: application,
		success: jobSubmitSuccess,
		error: apiErrorResponse,
		dataType: "text"
	});
}

$(document).ready(function() {
	console.log("document ready!");
	
	$("#submitJob").submit(function(event) {
		console.log("Handler for .submit() called.");
		app = $("#application").val();
		submitJob(app);
		event.preventDefault();
	});

	
});
