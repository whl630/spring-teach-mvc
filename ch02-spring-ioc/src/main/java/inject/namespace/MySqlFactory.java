package inject.namespace;

/**
 * @author cj
 * @date 2019/10/18
 */
public class MySqlFactory {
    private MyDataSource dataSource ;

    public MySqlFactory(MyDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public MyDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(MyDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
