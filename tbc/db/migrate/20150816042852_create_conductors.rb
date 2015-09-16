class CreateConductors < ActiveRecord::Migration
  def change
    create_table :conductors do |t|
      t.string :nombre
      t.integer :cedula

      t.timestamps
    end
  end
end
