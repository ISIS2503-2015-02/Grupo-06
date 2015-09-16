class AddCorreoToUsuarios < ActiveRecord::Migration
  def change
    add_column :usuarios, :correo, :string
  end
end
