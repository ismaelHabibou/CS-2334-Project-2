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

---
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

---
### EvolvedCell
This class extends Cell. It has only one data field which is the sub rule number. It has the following methods:
#### +EvolveCell(state: CellSatte, subruleNum: int): int
Constructor used to construct an instance of the EvolvedCell class.
#### +getSubruleNum(): int
This method returns the sub rule number of the cell.
- [x] is implemented?

---
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

---
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

---
### BoundaryConditions (Interface)
This interface has a single abstract method. 
#### +getNeighbor(cellIdx: int, offset: int, Generation gen): Cell  
This method returns the neighbor at index **cellIdx + offset** of a cell at index **cellIIdx**.

---
### FixedBoundaryConditions 
This a concrete class tha implements the **BoundaryConditions**  interface. It has the following data fields:
- LeftState: CellState;
- rightState: CellState;
#### +FixedBoundaryConditions(left: CellState, right: CellState)
Constructor for creating an instance of the class.
#### +getLeftState(): CellState
Returns the **leftState** used to construct  an instance of this class.
- [x] is implemented?
#### +getRightState(): CellState
Returns the **rightState** used to construct an instance of this class.
- [x] is implemented?
#### +getNeighbor(cellIdx: int, offset: int, Generation gen): Cell  
This method is used to return the neighbor of the cell at index **cellIdx** in the generation. Because of fixed boundary conditons, a generation is treated as array with infinite number of entries so for example if the neighbor is at the left of cell at **cellIdx** in the generation, a cell with **leftState is returned** else a cell with **rightState is returned**.
- [x] is implemented?

---
### CircularBoundaryConditions
This is yet another concrete class which implements the **BoundaryConditions** interface. This class does not have any data fields but it has some methods:
#### +CircularBoundaryContions()
This constructor is used to create an instance of this class.
#### +getNeighbor(cellIdx: int, offset: int, Generation gen): Cell  
In this method, the generation is treated as a circle and using modulus, we are going to get the state of the neighbor cell.
- [x] is implemented?

---
### _Rule_
This is an abstract class that governs the evolution of the automaton. It has the following abstract method:
#### +_getNumSubrules():_
#### +_getNeighborhood(cellIdx: int, gen: Generation, bc: BoundaryConditions): Cell[]_
#### +_evolve(neighborhood: Cell[]): EvolvedCell[]_
#### +_toString(): String_
The **Rule** has the following non abstract method:
#### #Rule(ruleNum: int)
Create a rule from a rule number.

#### +getRuleNum(): int
Return the rule number used to create the rule.

#### +evolve(gen: Generation, bc: BoundaryConditions): Generations
- [x] is implemented?

---
### ElementaryRule
This class represents  an elementary rule as depicted in Wolfram's book. This class has the following method:
#### +ElementaryRule (ruleNum: int)
Constructor for creating an elementary rule.

#### +getNumSubrules(): int 
Return the length of the rule table.
- [x] is implemented?

#### +getNeighborhood(cellIIdx: int, gen: Generation, bc: BoundaryConditions) : Cell[]
Return an array containing the cell at ** cellIdx ** and its adjacent neighbors.
- [x] is implemented?

#### +evolve(neighborhood: cell[]) : EvolvedCell[]
Evolve the cell and its neighborhood cell.
- [x] is implemented?

#### +toString(): String
Return the string representation of the rule.
- [x] is implemented?

---
### TotalisticRule
This class represents the rule that governs the evolution of a totalistic cellular automaton with a radius of 2.

#### +ToatalisticRule(ruleNum: int)
Constructor for creating an instance of totalistic rule.

#### +getNumSubrules(): int 
Return the length of the rule table.
- [x] is implemented?

#### +getNeighborhood(cellIIdx: int, gen: Generation, bc: BoundaryConditions) : Cell[]
Return an array containing the cell at **cellIdx**  and its adjacent neighbors.
- [x] is implemented?

#### +evolve(neighborhood: cell[]) : EvolvedCell[]
Evolve the cell and its neighborhood cell.
- [x] is implemented?

#### +toString(): String
Return the string representation of the rule.
- [x] is implemented?

