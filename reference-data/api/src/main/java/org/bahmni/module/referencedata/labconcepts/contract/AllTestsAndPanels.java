package org.bahmni.module.referencedata.labconcepts.contract;

public class AllTestsAndPanels extends Resource {
    private String description;

    private TestsAndPanels testsAndPanels;

    public TestsAndPanels getTestsAndPanels() {
        return testsAndPanels;
    }

    public void setTestsAndPanels(TestsAndPanels testsAndPanels) {
        this.testsAndPanels = testsAndPanels;
    }

    public static final String ALL_TESTS_AND_PANELS = "All_Tests_and_Panels";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
