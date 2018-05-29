import java.util.List;
import edu.udo.cs.swtsf.core.Entity;
import edu.udo.cs.swtsf.core.EntityStream;
import edu.udo.cs.swtsf.core.EntityBehaviorStrategy;
import edu.udo.cs.swtsf.core.Game;
import edu.udo.cs.swtsf.core.GameKey;
import edu.udo.cs.swtsf.core.player.Player;

public class Stopper implements EntityBehaviorStrategy{

	public static final int COOLDOWN = 500;
	public static final GameKey KEY = GameKey.S;
	
	private int coolDownTimer = 0;
	
	public void act(Entity host) {
		
		if (coolDownTimer > 0) {
			coolDownTimer--;
			return;
		}		
		
		Player player = (Player) host;
		Game game = host.getCurrentGame();
		
		if (game.isPressed(KEY)) {		

			EntityStream<Entity> stream = game.getAllEntities().without(player).withinRadiusOfEntity(player, 300);
						
			List<Entity> entityList = stream.createList();
							
			for(Entity ent : entityList){
				ent.setSpeedForward(0);
				ent.setSpeedBackwards(0);
			}										
			coolDownTimer = COOLDOWN;			
		}
	}
	
}
