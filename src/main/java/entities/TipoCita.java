package entities;

public enum TipoCita {

	TASAR_PROPIEDAD{
		@Override
		public String toString() {
			return "Tasar Propiedad";
		}
	},
	MOSTRAR_PROPIEDAD{
		@Override
		public String toString() {
			return "Mostrar Propiedad";
		}
	},
	CELEBRACION_DE_CONTRATO{
		@Override
		public String toString() {
			return "Celebrar Contrato";
		}
	},
	OTRO{
		@Override
		public String toString() {
			return "Otro";
		}
	}
	
}
