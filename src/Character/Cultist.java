package Character;

import java.util.List;

import GameEngine.Character;
import GameEngine.Player;
import Enumerators.Roles;

public class Cultist extends Character {

	public Cultist(Player player) {
		super(Roles.Cultist, player);
	}

	@Override
	public boolean setTarget(List<Player> targets) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String doAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
