package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Простая задача");
        String[] subtasks = {"Подзадача 1", "Подзадача 2", "Подзадача 3"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Название встречи",
                "Проект задачи",
                "2023-08-17"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] tasks = todos.search("задач");
        Assertions.assertEquals(tasks.length, 3);

        int[] expectedIds = {5, 55, 555};
        int[] actualIds = {tasks[0].getId(), tasks[1].getId(), tasks[2].getId()};
        Assertions.assertArrayEquals(expectedIds, actualIds);
    }

    @Test
    public void shouldFindNoTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Простая задача");
        String[] subtasks = {"Подзадача 1", "Подзадача 2", "Подзадача 3"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Название встречи",
                "Проект задачи",
                "2023-08-17"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] tasks = todos.search("Строка, которой нет в задачах");
        Assertions.assertEquals(tasks.length, 0);
    }

    @Test
    public void shouldFindSpecificTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Простая задача");
        String[] subtasks = {"Подзадача 1", "Подзадача 2", "Подзадача 3"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Название встречи",
                "Проект задачи",
                "2023-08-17"
        );

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] tasks = todos.search("Подзадача 3");
        Assertions.assertEquals(tasks.length, 1);
        Assertions.assertEquals(tasks[0].getId(), 55);
    }
}
