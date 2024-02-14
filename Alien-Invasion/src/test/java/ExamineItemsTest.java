class ExamineItemsTest {

    @org.junit.jupiter.api.Test
    void examine() {

        ExamineItems.examine("examine west-door");
        System.out.println(ExamineItems.getInteractable());
        ExamineItems.examine("analyze board");
    }
}