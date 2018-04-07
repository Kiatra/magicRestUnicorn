package at.jsommer.unicorn;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("unicorns")
public class UnicornResource {

	@GET
	@Path("/hello")
	public String unicorn() {
		return "wihhaaa I am a unicorn!! :)";
	}
	
	@GET
	@Path("/beyourself") //http://localhost:8080/magicRestUnicorn/magic/unicorns/beyourself
	@Produces("image/png")
	public Response getFullImage() {

	    BufferedImage image;
	    byte[] imageData = null;
	    
		try {
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("IMG_1_small.jpg"));
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ImageIO.write(image, "png", baos);
		    imageData = baos.toByteArray(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

	    return Response.ok(new ByteArrayInputStream(imageData)).build();
	}
}
