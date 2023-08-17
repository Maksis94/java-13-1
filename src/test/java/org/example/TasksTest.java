package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Название задачи");
        Assertions.assertTrue(simpleTask.matches("Название"));
        Assertions.assertFalse(simpleTask.matches("Строка, которой нет в задаче"));
    }

    @Test
    public void shouldMatchEpic() {
        Epic epic = new Epic(1, new String[]{"Первая задача",
                "Вторая задача", "Третья задача"});
        Assertions.assertTrue(epic.matches("Первая"));
        Assertions.assertTrue(epic.matches("Вторая"));
        Assertions.assertTrue(epic.matches("Третья"));
        Assertions.assertTrue(epic.matches("задача"));
        Assertions.assertFalse(epic.matches("Строка, которой нет в задаче"));
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(1, "Тема встречи", "Проект встречи", "2023-08-17");
        Assertions.assertTrue(meeting.matches("Тема"));
        Assertions.assertTrue(meeting.matches("Проект"));
        Assertions.assertFalse(meeting.matches("Строка, которой нет в задаче"));
    }

}
