import java.util.Stack;
import javafx.scene.paint.Color;


public class PaintBrush
{

	
	Paint paint;
	
	
	enum BrushMode{
		paintMode,
		fillMode,
		pattern1Mode,
		pattern2Mode
	}

	BrushMode mode;
	
	Paint Gold = new PaintColor(Color.GOLD);
	Paint White = new PaintColor(Color.WHITE);
	
	
/**
set the "paint" for the paintbrush
*/	
	public void setPaint(Paint paint)
	{
		this.paint = paint;
   
	}


/*
   gets the present paint on the paint brush
*/
	public Paint getPaint()
	{
		return paint;
	}
	
   
   /*
   makes the paint on the paint brush a brigter shade.
   */
	public void setBrighter()
	{		
		PaintBrighter x = new PaintBrighter(paint);
		this.paint = x;
	
	}


   /*
      makes the paint on the paintbrush a darker shade
   */
	public void setDarker()
	{
		PaintDarker y = new PaintDarker(paint);
		this.paint = y;
	}


   /*
      paints the mesh, using the current paint and mode at point x,y
   */
	
	//SET UP SMALLER FXNS FOR EACH MODE
	public void paint(int x, int y, Paint[][] mesh)
	{
		System.out.println("x "+ x);
		System.out.println("y "+ y);
		
		if(mode == BrushMode.paintMode)
		{
			mesh[x][y] = paint;
		}
		
		if(mode == BrushMode.fillMode)
		{
			if (!mesh[x][y].getColor().equals(White.getColor()) && !mesh[x][y].getColor().equals(paint.getColor())) {
				
				mesh[x][y] = paint;
			}
			
			if(x - 1 >= 0 && y - 1 >= 0 && x + 1 < 50 && y + 1 < 50) {
				
				if (!mesh[x-1][y].getColor().equals(White.getColor()) && !mesh[x-1][y].getColor().equals(paint.getColor()))
				{
					paint(x-1, y, mesh);
				}
				
				if (!mesh[x][y-1].getColor().equals(White.getColor()) && !mesh[x][y-1].getColor().equals(paint.getColor()))
				{
					paint(x, y-1, mesh);
				}
				
				if (!mesh[x+1][y].getColor().equals(White.getColor()) && !mesh[x+1][y].getColor().equals(paint.getColor()))
				{
					paint(x+1, y, mesh);
				}
				
				if (!mesh[x][y + 1].getColor().equals(White.getColor()) && !mesh[x][y+1].getColor().equals(paint.getColor()))
				{
					paint(x, y+1, mesh);
				}
			
			}
		}
		
		if(mode == BrushMode.pattern1Mode)
		{
			if (!mesh[x][y].getColor().equals(White.getColor()) && !mesh[x][y].getColor().equals(Gold.getColor())) {
				if (x % 2 == 0)
				{
					mesh[x][y] = Gold;
				}
				else
				{
					mesh[x][y] = White;
				}
			}
			
			if(x - 1 >= 0 && y - 1 >= 0 && x + 1 < 50 && y + 1 < 50) {
				
				if (!mesh[x-1][y].getColor().equals(White.getColor()) && !mesh[x-1][y].getColor().equals(Gold.getColor()))
				{
					paint(x-1, y, mesh);
				}
				
				if (!mesh[x][y-1].getColor().equals(White.getColor()) && !mesh[x][y-1].getColor().equals(Gold.getColor()))
				{
					paint(x, y-1, mesh);
				}
				
				if (!mesh[x+1][y].getColor().equals(White.getColor()) && !mesh[x+1][y].getColor().equals(Gold.getColor()))
				{
					paint(x+1, y, mesh);
				}
				
				if (!mesh[x][y + 1].getColor().equals(White.getColor()) && !mesh[x][y+1].getColor().equals(Gold.getColor()))
				{
					paint(x, y+1, mesh);
				}
			
			}
		}
		
		if(mode == BrushMode.pattern2Mode)
		{
			if (!mesh[x][y].getColor().equals(White.getColor()) && !mesh[x][y].getColor().equals(Gold.getColor())) {
				if (y % 2 == 0)
				{
					mesh[x][y] = Gold;
				}
				else
				{
					mesh[x][y] = White;
				}
			}
			
			if(x - 1 >= 0 && y - 1 >= 0 && x + 1 < 50 && y + 1 < 50) {
				
				if (!mesh[x-1][y].getColor().equals(White.getColor()) && !mesh[x-1][y].getColor().equals(Gold.getColor()))
				{
					paint(x-1, y, mesh);
				}
				
				if (!mesh[x][y-1].getColor().equals(White.getColor()) && !mesh[x][y-1].getColor().equals(Gold.getColor()))
				{
					paint(x, y-1, mesh);
				}
				
				if (!mesh[x+1][y].getColor().equals(White.getColor()) && !mesh[x+1][y].getColor().equals(Gold.getColor()))
				{
					paint(x+1, y, mesh);
				}
				
				if (!mesh[x][y + 1].getColor().equals(White.getColor()) && !mesh[x][y+1].getColor().equals(Gold.getColor()))
				{
					paint(x, y+1, mesh);
				}
			
			}
		}
	}

	
	
/*
   set the drawing mode of the paint brush.
*/
	public void pointMode()
	{
		mode = BrushMode.paintMode;
	}

	public void fillMode()
	{
		mode = BrushMode.fillMode;
	}

	public void pattern1Mode()
	{
		mode = BrushMode.pattern1Mode;
	}

	public void pattern2Mode()
	{
		mode = BrushMode.pattern2Mode;
	}

}
