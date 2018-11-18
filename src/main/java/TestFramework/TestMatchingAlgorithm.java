package TestFramework;

import Mocks.BatchingModelInitializer;
import Mocks.DriverAndRiderMock;

public class TestMatchingAlgorithm {
    public static void main(String[] args) {
        Model.BatchingModel bm = BatchingModelInitializer.initializeEventModel();
        // dummy code
        DriverAndRiderMock.populateBatchingModel(bm);
        try {
            bm.matchRiderAndDriver();
        } catch (Exception e) {

        }
    }
}
