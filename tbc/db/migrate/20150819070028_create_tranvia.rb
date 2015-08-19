class CreateTranvia < ActiveRecord::Migration
  def change
    create_table :tranvia do |t|
      t.string :identificacion
      t.string :linea
      t.float :kilms_ultima_revision
      t.float :temperatura
      t.string :posicion
      t.string :estado
      t.boolean :boton_panico

      t.timestamps
    end
  end
end
