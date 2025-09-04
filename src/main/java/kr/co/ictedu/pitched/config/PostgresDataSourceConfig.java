package kr.co.ictedu.pitched.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
// CRITICAL FIX: This scan is now more specific.
// It only scans the 'AdminAuthDao' (assuming that's its new name) which should use PostgreSQL
// and explicitly tells it to use the 'postgresSqlSessionFactory' bean.
@MapperScan(value = "kr.co.ictedu.pitched.admin.dao", // Adjust this if the auth DAO is elsewhere
        sqlSessionFactoryRef = "postgresSqlSessionFactory")
public class PostgresDataSourceConfig {

    @Primary
    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgresSqlSessionFactory")
    public SqlSessionFactory postgresSqlSessionFactory(@Qualifier("postgresDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/AdminMapper.xml")); // Or your specific XML file for auth
        return sessionFactoryBean.getObject();
    }
}
