namespace java org.apache.airavata.sga.commons.db.model

typedef i32 integer
typedef i64 long
typedef string timestamp

struct ExperimentEntity {
    1: required string experimentId,
    2: required string experimentName,
    3: required string experimentStatus,
    4: required long experimentStartTime,
    5: required long experimentEndTime,
    6: required long experimentLastUpdatedTime
}

struct TaskStateEntity {
    1: required string taskId,
    2: required string taskName,
    3: required long taskStartTime,
    4: required long taskEndTime,
    5: required long taskLastUpdatedTime,
    6: required ExperimentEntity experiment
}

