class CreateReservas < ActiveRecord::Migration
  def change
    create_table :reservas do |t|
      t.datetime :fecha
      t.time :hora_de_salida
      t.time :hora_de_llegada
      t.string :direccion_salida
      t.string :diraccion_llegada
      t.string :estado
      t.string :ruta
      t.decimal :distancia
      t.integer :id_usuario

      t.timestamps
    end
  end
end

