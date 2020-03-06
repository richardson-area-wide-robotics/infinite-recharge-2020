package frc.robot.commands.climbingCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Climber;

/**
 * A complex climbing command that raises the elevator, drops it to place the hook,
 * then activates the winch to climb
 */
public class ClimbingCommandGroup extends SequentialCommandGroup {

    public ClimbingCommandGroup(Climber climber) {
        addCommands(new ElevatorUpCommand(climber), new ElevatorDownCommand(climber)); //, new winchCommand(climber));
        addRequirements(climber);
    }
}
