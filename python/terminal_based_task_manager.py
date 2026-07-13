import os
TASK_FILE = "tasks.txt"

def load_tasks():
    task = []
    if(os.path.exists(TASK_FILE)):
        with open(TASK_FILE,'r',encoding = "utf-8") as f:
            for line in f:
                text, status = line.strip().rsplit("||",1)
                tasks.append({"text": text, "done": status == "done"})
    return tasks
    
def save_tasks(tasks):
    with open(TASK_FILE, "w", encoding="utf-8") as f:
        for task in tasks:
            status = "done" if task["done"] else "not_done"
            f.write(f"{task['text']}||{status}\n")
            
def display_tasks(tasks):
    if not taks:
        print("No task found")
    else:
        for i, task in enumerate(tasks,1):
            checkbox = "done" if task["done"] else " "
            print(f"{i}. [{checkbox}] {tasl['text']}")
    print()
    
    
def task_manager():
    tasks = load_tasks()
            
    while True:
        print("\n------------- Task List Manager ---------------")
        print("1. Add Tasks")
        print("2. View tasks")
        print("3. mark tasks as complete")
        print("4. Delete Task")
        print("5. Exit")
        
        choice = input("Choose an option from 1-5").strip()

        match choie:
            case "1":
                text = input("Enter your task").strip()
                if text:
                    tasks.append({"text": text, "done": False})
                    save_tasks(tasks)
                else:
                    print("task cannot be empty")
                    
            case "2":
                display_tasks(tasks)
                
            case "3":
                display_tasks(tasks)
                try:
                    int(input("Enter task number"))
                    if 1 <= num <= len(tasks):
                        tasks[num - 1]["done"] = True
                        save_tasks(tasks)
                        print("task marked as done")
                    else:
                        print("Invalid task number")
                except valueError:
                    print("Please Enter a number")
                    
            case "4":
                display_tasks(tasks)
                try:
                    int(input("Enter task number you want to delete"))
                    if 1 <= num <= len(tasks):
                        removed = tasks.pop(num - 1)
                        save_tasks(tasks)
                        print(f"task removed {removed['text']}")
                    else:
                        print("Invalid task number")
                except valueError:
                    print("Please Enter a number")
                    
            case "5":
                print("Exiting task manager")
                break
            case _:
                print("please choose a valid option")
                
task_manager()
