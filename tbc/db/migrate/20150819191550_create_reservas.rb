class CreateReservas < ActiveRecord::Migration
  def change
    create_table :reservas do |t|
      t.date :fecha
      t.string :direccionOrigen
      t.string :direccionLlegada
      t.string :estado
      t.time :horaSalida
      t.time :horaLlegada
      t.string :ruta
      t.decimal :distancia

      t.timestamps
    end
  end
end
