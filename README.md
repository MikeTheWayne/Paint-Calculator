# PaintCalculator
 Application for calculating the volume, floor area, and amount of paint required to paint the walls of a room, based on input dimensions.

## Running the application
 In order to run the application, simply download the file called "Paint Calculator.jar", then double click it to run the application.
 
## Given more time, I would implement:
- Validation for input and calculation overflows. While long values were used throughout to increase the upper limit of the amount of wall can be calculated (for extra large walls, or extra-precise calculations), no overflow validation was implemented.
- Error messages displayed to the user via the UI. Currently this is not taking place at all, with the only error message being printed to the console.
- A prettier UI. As time was running short, the UI is very basic, and may not be considered especially visually appealing.
- More room shapes. Currently the CuboidRoom is the only room shape set up, but the backend is designed to allow for other room types to easily be added.
- A UI component to allow for switching between room types. This will allow the user to easily switch between the different room types directly from the UI. The design supports this with unrestricted input dimensions, but the ability to change between room shapes is not on the UI.
- Decimal handling. The application is still usable without it, as the user can simply enter their measurements to the smallest unit of precision, but this detracts from the overall experience.
- Clear units. At the moment, both input and output are arbitrary numbers, with no real meaning. Adding units would improve the user experience.

## Assumptions
- The user wishes to receive all three calculations at the same time. On low-power or real-time systems, the user could be given the option to select which calculation they need at that time, saving the power or time costs of unnecessary additional processing. This could also be implemented to reduce visual clutter; while there are currently only three results being printed to the screen, should the requirements increase to hundreds of calculations, displaying them all simultaneously would vastly decrease the visual experience.
- The user will not be running these calculations repeatedly and rapidly. The current implementation creates new objects every calculation, relying on the garbage collector to get rid of the old objects. Should memory and calculations per second be critical factors, the objects should be kept in memory while the calculate button is usable, and the values should be changed using setters, rather than being passed through only in the instantiation.
- The user has a machine with a JVM installed. This program is written in Java, meaning a JVM would be required to run the application. Thankfully, the most widely used personal computing operating systems support the JVM, however should the client require the program to run on a more obscure operating system, such as an embedded device, then a low-level language such as C would be required in conjuction with a suitable compiler for the OS's machine code. If no such compiler exists, then Assembly be most suited for the development of the application.