class CreateEmergencia < ActiveRecord::Migration
  def change
    create_table :emergencia do |t|
      t.integer :magnitud
      t.string :posicion
      t.string :tipo_vehiculo
      t.string :id_vehiculo
      t.datetime :fecha

      t.timestamps
    end
  end
end
