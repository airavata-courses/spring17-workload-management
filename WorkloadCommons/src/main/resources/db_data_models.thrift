namespace java org.apache.airavata.sga.commons.db.model

typedef i32 integer
typedef i64 long
typedef string timestamp

struct ExperimentEntity {
    1: required string experimentId,
    2: required string experimentName,
    3: required string experimentStatus,
    4: required string experimentType,
    5: required long experimentStartTime,
    6: optional long experimentEndTime,
    7: optional long experimentLastUpdatedTime
}

struct TaskStateEntity {
    1: required string taskId,
    2: required string taskName,
    3: required long taskStartTime,
    4: optional long taskEndTime,
    5: optional long taskLastUpdatedTime,
    6: required ExperimentEntity experiment
}

