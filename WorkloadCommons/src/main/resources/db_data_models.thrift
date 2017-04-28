namespace java org.apache.airavata.sga.commons.db.model

typedef i32 integer
typedef i64 long
typedef string timestamp

struct ExperimentEntity {
    1: required string experimentId,
    2: required string experimentName,
    3: required string experimentStatus,
    4: required long experimentStartTime,
    5: optional long experimentEndTime,
    6: optional long experimentLastUpdatedTime
}

struct TaskStateEntity {
    1: required string taskId,
    2: required string taskName,
    3: required long taskStartTime,
    4: optional long taskEndTime,
    5: optional long taskLastUpdatedTime,
    6: required ExperimentEntity experiment
}

