package com.bf.exercise.ac.model;

public class Aircraft {
		private Long id;
		private Long ac_type;
		private Long ac_size;

		public Aircraft() {
			super();
		}

		public Aircraft(Long id, Long ac_type, Long ac_size) {
			super();
			this.id = id;
			this.ac_type = ac_type;
			this.ac_size = ac_size;
		}

		public Long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Long getACType() {
			return ac_type;
		}

		public void setACType(long ac_type) {
			this.ac_type = ac_type;
		}

		public Long getACSize() {
			return ac_size;
		}

		public void setACSize(long ac_size) {
			this.ac_size = ac_size;
		}
}
