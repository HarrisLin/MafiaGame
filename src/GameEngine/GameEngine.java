package GameEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameEngine The game engine is responsible for keeping track of everything
 * that happens in the game. This will include: - Keeping a map of all Players
 * and their Character role - Assigning roles to all Players - Acting as an
 * interface to allow human players to set targets for their actions - Invoking
 * the actions of all Characters when it is night-time
 */
public class GameEngine {

	private static Map<Player, Character> player_character_map = new HashMap<Player, Character>();
	// List of players still alive, used for setTarget() method in Character
	// Class
	public static List<Player> alive_player = new ArrayList<Player>();
	public static List<Player> dead_player = new ArrayList<Player>();

	/**
	 * This method returns the list of dead players
	 * @return dead_player - List of Dead Players
	 */
	private static List<Player> getDead_player() {
		return dead_player;
	}

	/**
	 * @param dead_player the dead_player to set
	 */
	private static void setDead_player(List<Player> dead_player) {
		GameEngine.dead_player = dead_player;
	}

	/**
	 * GameEngine.registerPlayer Registers a player into the game.
	 * 
	 * @param name
	 * @return true if successful, false if not.
	 */
	public static boolean registerPlayer(String name) {
		return Player.register(name);
	}
	
	/**
	 * GameEngine.registerPlayer De-registers a player from the game.
	 * 
	 * @param name
	 * @return true if successful, false if not.
	 */
	public static boolean removePlayer(String name) {
		return Player.remove(name);
	}

	/**
	 * GameEngine.getCharacter
	 * 
	 * @param player
	 *            The human name of the player
	 * @return Gets the character role of the player
	 */
	public static Character getCharacter(Player player) {
		return player_character_map.get(player);
	}

	/**
	 * @return list of all the character
	 */
	public static List<Player> getAlivePlayer() {
		return new ArrayList<Player>(alive_player);
	}
	
	/**
	 * @return TRUE if successfully killed and FALSE if not
	 */
	public static boolean killPlayer(Player player) {
		dead_player.add(player);
		return alive_player.remove(player);
	}
	
	/**
	 * GameEngine.assignCharacters Randomly assigns a character role to all
	 * players
	 * @return TRUE if characters successfully assigned and FALSE it not
	 */
	public static boolean assignCharacters() {
		// TODO: implement me!
		return true;
	}

	/**
	 * GameEngine.assignCharacter Assigns a single character role to a single
	 * player
	 * 
	 * @return TRUE if characters successfully assigned and FALSE it not
	 */
	public static boolean assignCharacter(Player player, Character character) {
		if(!Player.getAllPlayers().contains(player) || player == null || character == null) {
			return false;
		}
		player_character_map.put(player, character);
		alive_player.add(player);
		return true;
	}

	/**
	 * GameEngine.setTarget
	 * 
	 * @param player
	 *            The player performing the action
	 * @param targets
	 *            The target(s) of the action
	 * @return true if target was successfully set, false otherwise
	 */
	public static boolean setTarget(Player player, List<Player> targets) {
		return player_character_map.get(player).setTarget(targets);
	}



	/**
	 * GameEngine.performNightActions Makes each character perform his/her night
	 * action
	 * 
	 * @return summary of all the deaths, last wills, etc.
	 */
	public static String performNightActions() {
		// TODO: implement me!
		return null;
	}

	/**
	 * Finds player with most lynch votes and kills them off
	 * 
	 * @return the player lynched
	 */
	public static void lynch() {
		
		Player popular = alive_player.get(0);
		int maxVote = alive_player.get(0).getLynchVotes();
		
		for(int players = 0; players < alive_player.size(); players++) {
			if (alive_player.get(players).getLynchVotes() > maxVote) {
				maxVote = alive_player.get(players).getLynchVotes();
				popular = alive_player.get(players);
			} else if (alive_player.get(players).getLynchVotes() == maxVote) {
				// TODO
			}
		}
		alive_player.remove(popular);
	}
}
