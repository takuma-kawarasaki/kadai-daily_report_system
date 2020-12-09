package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "employees")
@NamedQueries({
    @NamedQuery(
        name = "getAllEmployees",
        query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"
    ),
    @NamedQuery(
        name = "getEmployeesCount",
        query = "SELECT COUNT(e) FROM Employee AS e"
    ),
    @NamedQuery(
        name = "checkRegisteredCode",
        query = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :code"
    ),
    @NamedQuery(
        name = "checkLoginCodeAndPassword",
        query = "SELECT e FROM Employee AS e WHERE e.delete_flag = 0 AND e.code = :code AND e.password = :pass"
    )
})
@Entity
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name = "admin_flag", nullable = false)
    private Integer admin_flag;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id セットする id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code セットする code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name セットする name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password セットする password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return admin_flag
     */
    public Integer getAdmin_flag() {
        return admin_flag;
    }

    /**
     * @param admin_flag セットする admin_flag
     */
    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    /**
     * @return created_at
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at セットする created_at
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * @return updated_at
     */
    public Timestamp getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at セットする updated_at
     */
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return delete_flag
     */
    public Integer getDelete_flag() {
        return delete_flag;
    }

    /**
     * @param delete_flag セットする delete_flag
     */
    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

}
