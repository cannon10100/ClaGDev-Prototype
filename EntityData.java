package com.cannon.basegame;

public class EntityData {
	
	private float x;
	private float y;
	private int[] inventory;
	private int health;
	private int entityType;
	private int itemId;
	

	public EntityData(Entity entity) {
		this.x = entity.getX();
		this.y = entity.getY();
		this.health = entity.getHealth();
		if(entity instanceof Player) {
			this.inventory = ((Player)(entity)).getInventoryIdArray();
			this.entityType = EntityData.PLAYER;
		} else if(entity instanceof Item) {
			this.itemId = ((Item)(entity)).getId();
			this.entityType = EntityData.ITEM;
		} else {
			this.entityType = EntityData.OTHER;
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int[] getInventoryIdArray() {
		return inventory;
	}

	public void setInventoryIdArray(int[] inventory) {
		this.inventory = inventory;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getEntityType() {
		return this.entityType;
	}
	
	public int getItemId() {
		return this.itemId;
	}
	
	
	public static final int PLAYER = 0;
	public static final int ITEM = 1;
	public static final int OTHER = 99;

}
