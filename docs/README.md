# Katappa User Guide


<img width="1465" height="830" alt="image" src="https://github.com/user-attachments/assets/1d545708-833b-4528-b3a0-5dfbbeb6c731" />

## Introduction
**Katappa** is a command-line task management chatbot that helps users create, organize, and track tasks using simple text commands.

Katappa supports three types of tasks:

- **todo** – simple tasks without dates  
- **deadline** – tasks with a due date  
- **event** – tasks with a start and end time  



## Adding `todo` task : `todo`
Adds the `todo` task. This is the simplest of the tasks, it just includes a description of the task.
Format `todo DESCRITPION`

Example: `todo return library book`

```
    =====================================
    As you command, My Lord. I have added:
    [T][ ] return library book
    Now you have 4 tasks.
    =====================================
```


## Adding `deadline` task : `deadline`
Adds tasks which have a specific deadline, you must also mention the deadline for the task, you mey either mention a particular date and time in the format `yyyy-MM-dd HHmm` or you may just type any text.
If deadline is entered as a date time format then it is possible to use the `due` feature too!
Format `deadline DESCRITPION /by DEADLINE`

Example: `deadline QF3103 Homework /by 2026-02-16 1800`

```
    =====================================
    As you command, My Lord. I have added:
    [D][ ] QF3103 Homework (by: 16 Feb 2026 18:00)
    Now you have 5 tasks.
    =====================================
```

## Adding `event` task : `event`
Adds tasks which are events, to add an event task you must enter details about the start period and end period of the event too.
Format `event DESCRITPION /from START TIME INDICATOR /to END TIME INDICATOR`

Example: `event meet PM. Modi for lunch /from Noon /to 2pm`

```
    =====================================
    As you command, My Lord. I have added:
    [E][ ] meet PM. Modi for lunch (from: Noon to: 2pm)
    Now you have 6 tasks.
    =====================================
```

## Viewing all the tasks : `list`
Shows all the current tasks with their description and other information about deadline (for `deadline`) and start and end time indicators (for `event`) and their status as done or not done.
Format `list`


Example: `list`

```
    =====================================
    Here are the tasks in your scroll, My Lord:
    1. [T][ ] CS2113 week 7 iP
    2. [D][ ] QF assigment (by: 16 Feb 2026 18:00)
    3. [E][ ] Give valedictorian speech (from: tomorrow 6pm to: 8pm)
    4. [T][ ] return library book
    5. [D][ ] QF3103 Homework (by: 16 Feb 2026 18:00)
    6. [E][ ] meet PM. Modi for lunch (from: Noon to: 2pm)
    =====================================
```

## Marking a task as Done : `mark`
Marks the task a done if it is currently marked at not done. It will give error message if the task index given is wrong.
Format: `mark INDEX`

Example: `mark 2`

```
    =====================================
    Nice! I've marked this task as done:
    [D][X] QF assigment (by: 16 Feb 2026 18:00)
    =====================================
```

## Marking a task as Not Done : `unmark`
Marks the task a not done if it is currently marked as done. It will give error message if the task index given is wrong.
Format: `unmark INDEX`

Example: `unmark 2`

```
    =====================================
    OK, I've marked this task as not done yet:
    [D][ ] QF assigment (by: 16 Feb 2026 18:00)
    =====================================
```


## Finding a task based on description : `find`
Finds all the tasks with the given text in the description of the tasks
Format: `find TEXT`

Example: `find work`

```
    =====================================
    My Lord, Here are the tasks in your scroll with the text "work" 
    1. [D][ ] QF3103 Homework (by: 16 Feb 2026 18:00)
    =====================================

```

## Find a `deadline` which is due: `due`
Finds all the deadlines which are due on the same day as inputted date by the user.

Format: `due yyyy-MM-dd`

Example: `due 2026-02-16`

```
    =====================================
    My Lord, Here are the tasks in your scroll which are due on "16 02 2026" 
    1. [D][ ] QF assigment (by: 16 Feb 2026 18:00)
    2. [D][ ] QF3103 Homework (by: 16 Feb 2026 18:00)
    =====================================
```

## Exit the chatbot : `bye`
Closes the programme and gives a ending message.

Format: `bye`

Example: `bye`

```
    =====================================
    Rest peacefully my Lord, katappa.Katappa's sword stays ready
    for your return.
    =====================================
```

## Saving the data
All the data related to tasks are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

