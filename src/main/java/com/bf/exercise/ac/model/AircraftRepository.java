package com.bf.exercise.ac.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AircraftRepository {
		@Autowired
		JdbcTemplate jdbcTemplate;

		class AircraftRowMapper implements RowMapper<Aircraft> {
			@Override
			public Aircraft mapRow(ResultSet rs, int rowNum) throws SQLException {
				Aircraft aircraft = new Aircraft();
				aircraft.setId(rs.getLong("id"));
				aircraft.setACType(rs.getLong("ac_type"));
				aircraft.setACSize(rs.getLong("ac_size"));
				return aircraft;
			}
		}

		public List<Aircraft> listAll() {
			return jdbcTemplate.query("select * from ac order by ac_type asc, ac_size asc, id desc", new AircraftRowMapper());
		}

		public int delete(long id) {
			return jdbcTemplate.update("delete from ac where id=?", new Object[] { id });
		}

		public int insert(Aircraft aircraft) {
			return jdbcTemplate.update("insert into aircraft (id, ac_type, ac_size) " + "values(?,  ?, ?)",
					new Object[] { aircraft.getId(), aircraft.getACType(), aircraft.getACSize() });
		}

}
