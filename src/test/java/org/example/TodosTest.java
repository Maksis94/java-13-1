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
        Task[] expected = {simpleTask, epic, meeting};
        Assertions.assertArrayEquals(expected, tasks);
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
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, tasks);
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
        Task[] expected = {epic};
        Assertions.assertArrayEquals(expected, tasks);
    }
}
