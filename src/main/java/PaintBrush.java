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
		Color oColor = mesh[x][y].getColor();
		
		if(mode == BrushMode.paintMode)
		{
			mesh[x][y] = paint;
		}
		
		if(mode == BrushMode.fillMode)
		{
			recursiveFill(x,y,mesh, oColor);
		}
		
		if(mode == BrushMode.pattern1Mode)
		{
			recursiveP1(x,y,mesh,oColor);
		}
		
		if(mode == BrushMode.pattern2Mode)
		{
			recursiveP2(x,y,mesh,oColor);
		}
	}

	private void recursiveFill(int x, int y, Paint[][]mesh, Color oColor)
	{
		if (mesh[x][y].getColor().equals(oColor)) {
			
			mesh[x][y] = paint;
		}
		
		if(x > 0 && y > 0 && x < mesh.length - 1 && y < mesh[0].length - 1) {
			
			
			if (mesh[x-1][y].getColor().equals(oColor))
			{
				recursiveFill(x-1, y, mesh, oColor);
			}
			
			if (mesh[x][y-1].getColor().equals(oColor))
			{
				recursiveFill(x, y-1, mesh, oColor);
			}
			
			if (mesh[x+1][y].getColor().equals(oColor))
			{
				recursiveFill(x+1, y, mesh, oColor);
			}
			
			if (mesh[x][y + 1].getColor().equals(oColor))
			{
				recursiveFill(x, y+1, mesh, oColor);
			}
		
		}
	}
	
	private void recursiveP1(int x, int y, Paint[][]mesh, Color oColor)
	{
		if (mesh[x][y].getColor().equals(oColor)) {
			
			if (y % 2 == 0)
			{
				mesh[x][y] = Gold;
			}
			else
			{
				mesh[x][y] = White;
			}
		}
		
		if(x - 1 >= 0 && y - 1 >= 0 && x + 1 < mesh.length && y + 1 < mesh[0].length) {
			
			
			if (mesh[x-1][y].getColor().equals(oColor))
			{
				recursiveP1(x-1, y, mesh, oColor);
			}
			
			if (mesh[x][y-1].getColor().equals(oColor))
			{
				recursiveP1(x, y-1, mesh, oColor);
			}
			
			if (mesh[x+1][y].getColor().equals(oColor))
			{
				recursiveP1(x+1, y, mesh, oColor);
			}
			
			if (mesh[x][y + 1].getColor().equals(oColor))
			{
				recursiveP1(x, y+1, mesh, oColor);
			}
		
		}
	}
	
	private void recursiveP2(int x, int y, Paint[][]mesh, Color oColor)
	{
		if (mesh[x][y].getColor().equals(oColor)) {
			
			if (x % 2 == 0)
			{
				mesh[x][y] = Gold;
			}
			else
			{
				mesh[x][y] = White;
			}
		}
		
		if(x - 1 >= 0 && y - 1 >= 0 && x + 1 < mesh.length && y + 1 < mesh[0].length) {
			
			
			if (mesh[x-1][y].getColor().equals(oColor))
			{
				recursiveP2(x-1, y, mesh, oColor);
			}
			
			if (mesh[x][y-1].getColor().equals(oColor))
			{
				recursiveP2(x, y-1, mesh, oColor);
			}
			
			if (mesh[x+1][y].getColor().equals(oColor))
			{
				recursiveP2(x+1, y, mesh, oColor);
			}
			
			if (mesh[x][y + 1].getColor().equals(oColor))
			{
				recursiveP2(x, y+1, mesh, oColor);
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
