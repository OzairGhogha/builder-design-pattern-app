package uos.BuilderScienceApp;


class Product {
    String mattertype, particles, shape;
	
    
	public void setMatterType(String mattertype)
    {
        this.mattertype = mattertype;
    }
	public void setParticles(String particles)
    {
        this.particles = particles;
    }
	public void setShape(String shape)
    {
        this.shape = shape;
    }

    public String getInfo()
    {
        return "This is a "+ mattertype + " which means particles are " + particles + " and the shape of the matter is " + shape;
    }


}


abstract class Builder {
	public Product getProduct()
    {
        return product;
    }
    void createNewProduct()
    {
        product = new Product();
    }
    abstract void buildMatterType();
    abstract void buildParticles();
    abstract void buildShape();

    Product product;
}

class WoodBuilder extends Builder
{

	public void buildMatterType()
    {
        product.setMatterType("Solid");
    }
	public void buildParticles()
    {
        product.setParticles("Stationary (Not Moving)");
    }
	public void buildShape()
    {
        product.setShape("Fixed (Cannot Change)");
    }
	
}

class WaterBuilder extends Builder
{

	public void buildMatterType()
    {
        product.setMatterType("Liquid");
    }
	public void buildParticles()
    {
        product.setParticles("Moving");
    }
	public void buildShape()
    {
        product.setShape("Dependant (Takes the shape of its container)");
    }
	
}

class OxygenBuilder extends Builder
{

	public void buildMatterType()
    {
        product.setMatterType("Gas");
    }
	public void buildParticles()
    {
        product.setParticles("Moving");
    }
	public void buildShape()
    {
        product.setShape("Dependant (Fills the shape of its container)");
    }
	
}

class RockBuilder extends Builder
{

	public void buildMatterType()
    {
        product.setMatterType("Solid");
    }
	public void buildParticles()
    {
        product.setParticles("Stationary (Not Moving)");
    }
	public void buildShape()
    {
        product.setShape("Fixed (Cannot Change)");
    }
	
}

class HeliumBuilder extends Builder
{

	public void buildMatterType()
    {
        product.setMatterType("Gas");
    }
	public void buildParticles()
    {
        product.setParticles("Moving");
    }
	public void buildShape()
    {
        product.setShape("Dependant (Fills the shape of its container)");
    }
	
}




class Director
{
	Builder builder = null;

	
	public void setBuilder(Builder b)
	{
		builder = b;
	}
	public Product getProduct()
	{
		return builder.getProduct();
	}

	void constructProduct()
	{
		builder.createNewProduct();
		builder.buildMatterType();
		builder.buildParticles();
		builder.buildShape();
	}
}

