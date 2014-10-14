package org.bahmni.module.admin.csv.exporter;

import org.bahmni.module.admin.csv.models.ConceptRow;
import org.bahmni.module.admin.csv.models.ConceptRows;
import org.bahmni.module.admin.csv.models.ConceptSetRow;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.openmrs.api.APIException;
import org.openmrs.web.test.BaseModuleWebContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@org.springframework.test.context.ContextConfiguration(locations = {"classpath:TestingApplicationContext.xml"}, inheritLocations = true)
public class ConceptSetExporterIT extends BaseModuleWebContextSensitiveTest {

    @Autowired
    private ConceptSetExporter conceptSetExporter;

    @Before
    public void setUp() throws Exception {
        executeDataSet("conceptExportSetup.xml");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throw_exception_if_concept_does_not_exist() throws Exception {
        exception.expect(APIException.class);
        exception.expectMessage("Concept Does not exist not found");
        conceptSetExporter.exportConcepts("Does not exist");
    }

    @Test
    public void get_list_of_conceptRows() throws Exception {
        ConceptRows result = conceptSetExporter.exportConcepts("Big Concept");
        List<ConceptRow> conceptRows = result.getConceptRows();
        List<ConceptSetRow> conceptSetRows = result.getConceptSetRows();
        assertEquals(8, conceptRows.size());
        ConceptRow child1 = conceptRows.get(3);
        ConceptRow child2 = conceptRows.get(5);
        ConceptRow child3 = conceptRows.get(7);
        ConceptRow child4 = conceptRows.get(6);
        ConceptRow answer01 = conceptRows.get(0);
        ConceptRow answer11 = conceptRows.get(1);
        ConceptRow answer12 = conceptRows.get(2);
        ConceptRow answer21 = conceptRows.get(4);
        assertEquals("Answer1", answer11.name);
        assertEquals("Answer0", answer01.name);
        assertEquals("Answer2", answer12.name);
        assertEquals("Answer3", answer21.name);
        assertEquals("Child1", child1.name);
        assertEquals("Child2", child2.name);
        assertEquals("Child3", child3.name);
        assertEquals("Child4", child4.name);
        assertEquals("Document", child1.dataType);
        assertEquals("Document", child2.dataType);
        assertEquals("Document", child3.dataType);
        assertEquals("New Class", child1.conceptClass);
        assertEquals("New Class", child2.conceptClass);
        assertEquals("New Class", child3.conceptClass);
        assertEquals(1, child1.getSynonyms().size());
        assertEquals(1, child2.getSynonyms().size());
        assertEquals(0, child3.getSynonyms().size());
        assertEquals(2, child1.getAnswers().size());
        assertEquals(1, child2.getAnswers().size());
        assertEquals(0, child3.getAnswers().size());
        assertEquals("Concept1 Description", child1.getDescription());
        assertNull(child2.getDescription());
        assertNull(child3.getDescription());
        assertEquals("New Code", child3.referenceTermCode);
        assertEquals("SAME-AS".toLowerCase(), child3.referenceTermRelationship.toLowerCase());
        assertEquals("org.openmrs.module.emrapi", child3.referenceTermSource);
        assertEquals(2, conceptSetRows.size());
        ConceptSetRow small = conceptSetRows.get(0);
        ConceptSetRow big = conceptSetRows.get(1);
        assertEquals("Small Concept", small.name);
        assertEquals("Big Concept", big.name);

    }
}