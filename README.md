# File-System-Simulation

You are to simulate accessing a virtual file system. 

First create three separate "drives" A, B, and C. Each is to have it's own
tree structure with directories and common files. Restrict the number of 
files under each directory to no more than five. Each common file is to have
it's own i-node which need contain only filename, extension, and one line of
UNIQUE data (in lieu of a pointer to the data on "disk"). For simplicity,
do not make the depth of any directory tree exceed four levels.

On top of these file systems build a VFS that makes the three separate systems
appear as one big system. All user accesses should be via the VFS through
the v-nodes that you provide. The only functions that the VFS is to provide
is add a new file, delete a file, and "print"(show the one line of data) a
file. You must demonstrate all three operations and show the user's view of
the file structure, as well as, the actual file system structure before and
after each operation.

As before, all commands are to be entered via a GUI except that a data
file may be used to build the initial system (instead of entering the
pieces one file at a time).
