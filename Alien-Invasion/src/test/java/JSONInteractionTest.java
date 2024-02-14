import json.ItemsJSON;
import org.junit.jupiter.api.Test;

class JSONInteractionTest {

    @Test
    void jsonReader() {
        ExamineItems.examine("analyze board");
        ItemsJSON.getDescription(ExamineItems.getInteractable());
        System.out.println(ItemsJSON.getCoordinates("item"));
    }
}