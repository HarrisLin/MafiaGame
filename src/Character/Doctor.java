package Character;

import Character.CharacterFactory.Roles;
import GameEngine.GameRegistration.Player;
import Resources.GameMessage;

public class Doctor extends Character {

	protected Doctor(Player player) {
		super(Roles.Doctor, player);
	}

	@Override
	public String performAction(Character target) {
		if(this.character_status.isBlocked()) {
			return GameMessage.Character.BLOCKED(player);
		}
		target.character_status.getVisitors().add(player);
		target.character_status.heal();
		return GameMessage.Character.DOCTOR_SUCCESS(player, target.player);
	}
}
