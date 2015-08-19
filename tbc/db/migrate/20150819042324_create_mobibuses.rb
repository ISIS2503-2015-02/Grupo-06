class CreateMobibuses < ActiveRecord::Migration
  def change
    create_table :mobibuses do |t|
      t.string :posicion
      t.string :estado
      t.string :kilms_ultima_revision

      t.timestamps
    end
  end
end
