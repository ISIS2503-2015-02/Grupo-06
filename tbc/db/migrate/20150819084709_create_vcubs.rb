class CreateVcubs < ActiveRecord::Migration
  def change
    create_table :vcubs do |t|
      t.string :posicion
      t.string :estado
      t.boolean :prestada
      t.integer :id_usuario

      t.timestamps
    end
  end
end
