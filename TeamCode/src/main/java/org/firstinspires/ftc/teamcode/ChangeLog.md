**Wilde Lake High School Robotics Code Change Log**
If you are viewing this on GitHub, please view it in the 'Code' mode.

**Version Goals:**
Version 1: Basic Movement - Done By 9-28-2023
Version 2: Basic Manual Mode - Done By 10-20-2023
Version 3: Perfected Manual Mode - Done By 11-1-2023
Version 4: Basic Autonomous - Done By 11-23-2023
Version 5: Perfected Autonomous  - Done By 12-10-2023

**Version 1.00**
Last Tested: 9-27-2023
Test Output: Ran as Wanted. No Errors

Changes Include:
1. Fixing Dual Motor Mode for controller input
2. Commenting Out Four Motor Mode

This is it. Version 1 is done. In Version two, we will work on prototyping arm and
grabber designs. DualAutoMode will also be getting changes for the purpose to test 
Sensors and Tenserflow in preparation for Versions 4 and 5.

**Version 0.12.1**
Last tested: 9-27-2023

Changes Include:
1. Commenting code
2. Adding Version Goals




**Version 0.12.0**
Last Tested: Never

Changes Include:
1. Adding DualAutoMode Class.

In this version, DualAutoMode serves as nothing but a test for a V2 Color Sensor.

I am starting on auto mode now, because time is limited and this will help identify changes in hardware that
may be needed before it takes an entire day to install a sensor.

**Version 0.11**
Last Tested: Never

Changes Include:
1. Programed dual motor mode as a basic movement code:
2. Updated Telemetry in both classes in a way that will show
joystick values while OPmode is running.

Once Tested and if working properly, this version may become Version 1.

**Version 0.10**
Last Tested: 9-21-2023
Test Output: Ran As Expected. No errors, and no Crashes.

Changes Include:
1. Updated Telemetry in both classes for better debuging

**Version 0.09**
Last Tested: Never

Changes Include:
1. Removed Hardware Class
2. Added resetRuntime(); to both remaining classes
3. Added Hardware Mapping to both remaining classes

Removing the hardware class will remove a possible point of error.

**Version 0.08**
Last Tested: 9-20-2023
Test Ouput: Reliable Control App Crash

Changes Include:
1. Removing BasicCode Class
2. Adding DualMotorMode Class & FourMotorMode Class
3. Renamed "readme.md" to "ChangeLog.md"

DualMotorMode Class: Exact Same as FourMotorModeClass with the exeption of 2 lines of code removed
and small edit to @TeleOp.

FourMotorMode is identical to BasicCode with a small change of declaring the class as
"FourMotorMode" instead of "BasicCode".

**Version 0.07**
Last Tested: Never

Changes Include:
1. Re-writing readme.md
2. Creating hardware mapping class so that auto mode and manual mode can be more easily coded while.
3. Re-writing BasicCode class in a way that utilizes the hardware class.
4. Updating @TeleOp in BasicCode
5. Deleting AutoMode.java to help minimize errors. (Auto Mode will come back)
