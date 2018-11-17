package Mocks;

import Model.BatchingModel;
import Model.Entities;

import java.util.Date;

public class BatchingModelInitializer {
    public static Model.BatchingModel mockBatchingModel= null;

    public static Model.BatchingModel initializeEventModel() {
        if (mockBatchingModel == null) {
            Entities.Event e = new Entities.Event("Oklahoma City Thunder at Sacramento Kings", new Date(2018, 11, 19 ))
            mockBatchingModel = new BatchingModel(e);
        }

        return mockBatchingModel;
    }
}
