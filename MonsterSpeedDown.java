import exercise.monsters.AbstractMonster;
import edu.udo.cs.swtsf.core.Entity;
import edu.udo.cs.swtsf.core.EntityBehaviorStrategy;

public class MonsterSpeedDown extends AbstractMonster{

	private int oldHitpoints;
	
	public MonsterSpeedDown() {
		setMaxHitpoints(10);
		setHitpoints(getMaxHitpoints());
		oldHitpoints = getHitpoints();
		
		delayBetweenAttacks = 50;
		damagePerHit = 2;
		maxSpeed = 5.5;
		acceleration = 0.05;		
		
		addDefaultStrategies();	
		addBehaviorStrategy(new SpeedDownStrategy());
	}
		
	public class SpeedDownStrategy implements EntityBehaviorStrategy {  
		
		public void act(Entity self) {
			if(getHitpoints()!=oldHitpoints && maxSpeed >= 0.5) {
				maxSpeed = maxSpeed - 0.5;
				oldHitpoints = getHitpoints();
			}
		}		
	}
			
}
