package kz.bitlab.techorda.db;

import java.util.ArrayList;

public class DBManager {
    private static final ArrayList<Tasks> tasks = new ArrayList<>();
    private static long id=5;
    static {
        tasks.add(new Tasks((long)1, "Gera", "software", "2024-04-12"));
        tasks.add(new Tasks((long)2, "Fatima", "finance", "2023-11-12"));
        tasks.add(new Tasks((long)3, "Asem", "security", "2023-04-16"));
        tasks.add(new Tasks((long)4, "Diana","history","2025-06-26"));
    }

    public static ArrayList<Tasks> getTasks() {
        return tasks;
    }

    public static void addTasks(Tasks task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Tasks getTask(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }


    public static void updateTask(Tasks task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                tasks.set(i, task);
                break;
            }
        }
    }

    public static void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                break;
            }
        }
    }

}
