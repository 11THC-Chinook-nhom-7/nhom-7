package Decorator;

public abstract class TraSuaDecorator implements CompomentTraSua {
    protected CompomentTraSua trasua;

    protected TraSuaDecorator(CompomentTraSua trasua) {
        this.trasua = trasua;
    }
    @Override
    public String getName() {
        return trasua.getName();
    }


}
