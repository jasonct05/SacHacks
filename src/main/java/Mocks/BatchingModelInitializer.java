package Mocks;

import Model.BatchingModel;
import Model.Event;

import java.time.LocalDateTime;

public class BatchingModelInitializer {
    public static Model.BatchingModel mockBatchingModel = null;

    public static Model.BatchingModel initializeEventModel() {
        if (mockBatchingModel == null) {
            LocalDateTime ldt = LocalDateTime.of(2018, 11, 21, 19, 00);
            Event e = new Event("Oklahoma City Thunder at Sacramento Kings", ldt);
            mockBatchingModel = new BatchingModel(e);
        }

        return mockBatchingModel;
    }
}
