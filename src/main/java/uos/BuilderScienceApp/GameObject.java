package uos.BuilderScienceApp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameObject implements CommandIF {
	GraphicsContext gc;
	double x, y;
	protected Image img;
	
	public GameObject(GraphicsContext gc, double x, double y) {
		super();
		this.gc = gc;
		this.x = x;
		this.y = y;
	}
	@Override
	public void _do() {
			gc.setFill(Color.BLUE);
		gc.fillRect(x, y, 5, 5);		
	}
	@Override
	public void _undo() {
			gc.setFill(Color.WHITE);
		gc.fillRect(x, y, 5, 5);		
	}
	public void update()
	{
	if(img!=null)
		gc.drawImage(img, x, y, 30, 30);
	}

}
