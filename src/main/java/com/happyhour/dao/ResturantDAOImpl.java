package com.happyhour.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.happyhour.model.Resturant;

/**
 * Class for Resturant interaction with DB
 * 
 * @author Mohit Bansal
 */
public class ResturantDAOImpl implements ResturantDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private Logger log = Logger.getLogger("ResturantDAOImpl");

	public JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		getJdbcTemplate();
	}

	public int insertResturant(Resturant resturant) {

		log.info("inserting the Resturant");

		String sql = "INSERT INTO Resturant "
				+ "(rest_name, rest_address, rest_pincode, rest_phone_num, rest_email,rest_login_id,rest_password,rest_type_id,created_date) VALUES (?, ?, ?,?,?,?,?,?,?)";

		int count = 0;
		try {
			count = jdbcTemplate.update(sql,
					new Object[] { resturant.getRestName(), resturant.getRestAddress(), resturant.getRestPincode(),
							resturant.getRestPhoneNum(), resturant.getRestEmail(), resturant.getRestLoginId(),
							resturant.getRestPassword(), resturant.getRestTypeId(), resturant.getCreatedDate() });
		} catch (Exception e) {
			log.info("error in inserting Resturant :" + e.getMessage());
		}

		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Resturant> getResturants() {
		String sql = "select id from Resturant";

		return jdbcTemplate.query(sql, new RowMapper() {

			public Object mapRow(ResultSet rs, int rownumber) throws SQLException {
				Resturant r = new Resturant();
				r.setId(rs.getInt(1));

				return r;
			}
		});

	}
}
