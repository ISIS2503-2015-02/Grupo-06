class CreateUsuarios < ActiveRecord::Migration
  def change
    create_table :usuarios do |t|
      t.string :nombre
      t.string :documento

      t.timestamps
    end
    create_table :reservas do |t|
      t.belongs_to :usuario, index: true
      t.integer :idUsuario
      t.string :nombreUsuario
      t.datetime :fecha
      t.time :hora_de_salida
      t.time :hora_de_llegada
      t.string :direccion_salida
      t.string :direccion_llegada
      t.string :estado
      t.string :ruta
      t.float :distancia

      t.timestamps
    end
  end
end
