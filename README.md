# Project 2 (Elementary Cellular Automaton)
>This project is an extension of the first project we did in CS2334. For more informations you can check the repostory of the first project. With that being said let's dive into coding, shall we? 
  
## Classes 
  
### **CellState**
This class represents the state of a cell in the automaton. It is an enum class that has two states **ON** and **OFF**, has private constructor (by default the constructor of an enum class is private), it has a static field called **SYMBOL_TO_STATE** which map  symbols to states. The enum class has the following method:

#### +GetState(Symbol : char) : CellSatte
This method takes a symbol and returns a cell state.
-  before test :  I thought this method takes a character and returns the state associated with charater.
-  after test : I still thought the method does the same thing that I described above.
- [x] Is implemented ?
  
  
####  +ToString(): String
This method returns the character (**symbol**) that represents the cellSatte
-  before test : returns the string representation of the character that represents the cell state.
-  after test: returns the character that represents the cellState.
- [x] is implemented?

### **Cell**
This class represents an individual cell in the generation of an automaton. It has only one data field which is the state of the cell. It has the following methods:

#### +Cell()
A constructor for creating a cell with a Cellstate **OFF**.
#### +Cell(state: CellState)
A constructor for constructing a cell with specified cell state.
#### +getState(): CellState
This method returns the state of the cell;
-  before test : returns the state of the cell
-  after test: returns the state of the cell.
- [x] is implemented?
#### +toString(): String
This method should return the symbol that represents the state of the cell.
-  before test : returns the string representation of the state of the cell.
-  after test: returns the string representation of the state of the cell.
- [x] is implemented?

### EvolvedCell
This class extends Cell. It has only one data field which is the sub rule number. It has the following methods:
#### +EvolveCell(state: CellSatte, subruleNum: int): int
Constructor used to construct an instance of the EvolvedCell class.
#### +getSubruleNum(): int
This method returns the sub rule number of the cell.
- [x] is implemented?

### Generation 
This class represents a generation in an automaton. An array of cells is the only data field in this class. It has the following methods:
#### +Generation(states: CellState[])
Constructor that is used to construct a generation from an array of CellState.
#### +Generation(states: String)
Constructor that is used to create a generation from a string of symbols.
#### +Generation(Cell[]: cells)
Constructor that is used to create a generation from an array of cells.
#### +size(): int
This method returns the size of the generation.
- [x] is implemented?
#### +geCell(idx:int) : Cell
Returns the cell at the position idx in the generation.
- [x] is implemented?

#### +toString(): String
Get the string representation of the generation.
- [x] is implemented?

### Automaton
This class has the following data fields:
- rule: Rule (This is the rule that governs the evolution of the automaton)
- generations: List< Generations > (This represents a container for the generations of the automaton)
- bc: BoundaryConditions (This is the conditions that are applied at the boundary of each generation)

#### +Automaton(rule: Rule, init: Generation, bc: BoundaryConditions)
Constructor used to create an automaton.
#### + getRule(): Rule
Returns the rule that governs the evolution of the automaton.
- [x] is implemented?
#### +getGeneration(stepNum: int): Generation
Return the generation at the specified **step number**.
- [x] is implemented?
#### +getBoundaryConditions(): BoundaryConditions
Return the boundary conditions.
- [x] is implemented?
#### +evolve(numSteps: int): void
Evolve the automaton by **numSteps**.
- [ ] is implemented?
#### +getTotalSteps(): int
Get the total number by which the automaton evolved.
#### +toString(): String
This method returns the string representation of the generation at the top.
- [x] is implemented?
#### +getHistory(): String
Get the string representation all the generations of the automaton.
- [x] is implemented?
