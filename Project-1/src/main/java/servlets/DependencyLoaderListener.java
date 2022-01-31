package servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import utils.GlobalStore;

public class DependencyLoaderListener implements ServletContextListener {
    
    private GlobalStore store;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        store = new GlobalStore();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public GlobalStore getStore() {
        return this.store;
    }

    public void setStore(GlobalStore store) {
        this.store = store;
    }
    
}

class DependencyLoader {

}
