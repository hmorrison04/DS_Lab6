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
	public void paint(int x, int y, Paint[][] mesh)
	{
		
		mesh[x][y] = paint;
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
